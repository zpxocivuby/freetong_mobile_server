package itaf.framework.web.util;

import itaf.framework.exception.bean.BusinessException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;

public class FileUtil {

	public static String FILE_WRITING_ENCODING = "UTF-8";

	private static org.apache.log4j.Logger m_oLogger = org.apache.log4j.Logger
			.getLogger(FileUtil.class);

	/**
	 * 构造函数
	 */
	public FileUtil() {

	}

	// ==================================================================
	// 文件名称分解的几个工具函数

	/**
	 * 检查指定文件是否存在
	 * 
	 * @param _sPathFileName
	 *            文件名称(含路径）
	 * @return 若存在，则返回true；否则，返回false
	 */
	public static boolean fileExists(String _sPathFileName) {
		File file = new File(_sPathFileName);
		return file.exists();
	}

	/**
	 * 检查指定文件的路径是否存在
	 * 
	 * @param _sPathFileName
	 *            文件名称(含路径）
	 * @return 若存在，则返回true；否则，返回false
	 */
	public static boolean pathExists(String _sPathFileName) {
		String sPath = extractFilePath(_sPathFileName);
		return fileExists(sPath);
	}

	/**
	 * 从文件的完整路径名（路径+文件名）中提取文件名(包含扩展名) <br>
	 * 如：d:\path\file.ext --> file.ext
	 * 
	 * @param _sFilePathName
	 * @return
	 */
	public static String extractFileName(String _sFilePathName) {
		return extractFileName(_sFilePathName, File.separator);
	}

	/**
	 * 从文件的完整路径名（路径+文件名）中提取文件名(包含扩展名) <br>
	 * 如：d:\path\file.ext --> file.ext
	 * 
	 * @param _sFilePathName
	 *            全文件路径名
	 * @param _sFileSeparator
	 *            文件分隔符
	 * @return
	 */
	public static String extractFileName(String _sFilePathName,
			String _sFileSeparator) {
		int nPos = -1;
		if (_sFileSeparator == null) {
			nPos = _sFilePathName.lastIndexOf(File.separatorChar);
			if (nPos < 0) {
				nPos = _sFilePathName
						.lastIndexOf(File.separatorChar == '/' ? '\\' : '/');
			}
		} else {
			nPos = _sFilePathName.lastIndexOf(_sFileSeparator);
		}

		if (nPos < 0) {
			return _sFilePathName;
		}

		return _sFilePathName.substring(nPos + 1);
	}

	/**
	 * 从EB路径地址中提取: 文件名
	 * 
	 * @param _sFilePathName
	 * @return
	 */
	public static String extractHttpFileName(String _sFilePathName) {
		int nPos = _sFilePathName.lastIndexOf("/");
		return _sFilePathName.substring(nPos + 1);
	}

	/**
	 * 从文件的完整路径名（路径+文件名）中提取:主文件名（不包括路径和扩展名）
	 * 
	 * @param _sFilePathName
	 * @return
	 */
	public static String extractMainFileName(String _sFilePathName) {
		String sFileMame = extractFileName(_sFilePathName);
		int nPos = sFileMame.lastIndexOf('.');
		if (nPos > 0) {
			return sFileMame.substring(0, nPos);
		}
		return sFileMame;
	}

	/**
	 * 排除文件的扩展名,只保留路径(如果存在)和主文件名
	 * 
	 * @param sFileMame
	 * @return
	 */
	public static String excludeFileExt(String sFileMame) {
		int nPos = sFileMame.lastIndexOf('.');
		if (nPos > 0) {
			return sFileMame.substring(0, nPos);
		}
		return sFileMame;
	}

	/**
	 * 从文件的完整路径名（路径+文件名）中提取: 文件扩展名
	 * 
	 * @param _sFilePathName
	 * @return
	 */
	public static String extractFileExt(String _sFilePathName) {
		int nPos = _sFilePathName.lastIndexOf('.');
		return (nPos >= 0 ? _sFilePathName.substring(nPos + 1) : "");
	}

	/**
	 * 从文件的完整路径名（路径+文件名）中提取 路径（包括：Drive+Directroy )
	 * 
	 * @param _sFilePathName
	 * @return
	 */
	public static String extractFilePath(String _sFilePathName) {
		int nPos = _sFilePathName.lastIndexOf('/');
		if (nPos < 0) {
			nPos = _sFilePathName.lastIndexOf('\\');
		}
		return (nPos >= 0 ? _sFilePathName.substring(0, nPos + 1) : "");
	}

	/**
	 * 将文件/路径名称转化为绝对路径名
	 * 
	 * @param _sFilePathName
	 *            文件名或路径名
	 * @return
	 */
	public static String toAbsolutePathName(String _sFilePathName) {
		File file = new File(_sFilePathName);
		return file.getAbsolutePath();
	}

	/**
	 * 从文件的完整路径名（路径+文件名）中提取文件所在驱动器 <br>
	 * 注意：区分两种类型的文件名表示 <br>
	 * [1] d:\path\filename.ext --> return "d:" <br>
	 * [2] \\host\shareDrive\shareDir\filename.ext --> return
	 * "\\host\shareDrive"
	 * 
	 * @param _sFilePathName
	 * @return
	 */
	public static String extractFileDrive(String _sFilePathName) {
		int nPos;
		int nLen = _sFilePathName.length();

		// 检查是否为 "d:\path\filename.ext" 形式
		if ((nLen > 2) && (_sFilePathName.charAt(1) == ':'))
			return _sFilePathName.substring(0, 2);

		// 检查是否为 "\\host\shareDrive\shareDir\filename.ext" 形式
		if ((nLen > 2) && (_sFilePathName.charAt(0) == File.separatorChar)
				&& (_sFilePathName.charAt(1) == File.separatorChar)) {
			nPos = _sFilePathName.indexOf(File.separatorChar, 2);
			if (nPos >= 0)
				nPos = _sFilePathName.indexOf(File.separatorChar, nPos + 1);
			return (nPos >= 0 ? _sFilePathName.substring(0, nPos)
					: _sFilePathName);
		}

		return "";
	}// END:extractFileDrive

	/**
	 * 删除指定的文件
	 * 
	 * @param _sFilePathName
	 *            指定的文件名
	 * @return
	 */
	public static boolean deleteFile(String _sFilePathName) {
		File file = new File(_sFilePathName);
		return file.exists() ? file.delete() : false;
	}

	// =======================================================================
	// 目录操作函数

	/**
	 * 创建目录
	 * 
	 * @param _sDir
	 *            目录名称
	 * @param _bCreateParentDir
	 *            如果父目录不存在，是否创建父目录
	 * @return
	 */
	public static boolean makeDir(String _sDir, boolean _bCreateParentDir) {
		boolean zResult = false;
		File file = new File(_sDir);
		if (_bCreateParentDir)
			zResult = file.mkdirs(); // 如果父目录不存在，则创建所有必需的父目录
		else
			zResult = file.mkdir(); // 如果父目录不存在，不做处理
		if (!zResult)
			zResult = file.exists();
		return zResult;
	}

	/**
	 * Deletes a file path, and all the files and subdirectories in this path
	 * will also be deleted.
	 * 
	 * @param _sPath
	 *            the specified path.
	 * @return <code>true</code> if the path exists and has been deleted
	 *         successfully; <code>false</code> othewise.
	 */
	public static boolean deleteDir(String _sPath) {
		File path = new File(_sPath);
		return deleteDir(path);
	}

	/**
	 * Deletes a file path, and all the files and subdirectories in this path
	 * will also be deleted.
	 * 
	 * @param _path
	 *            the specified path.
	 * @return <code>true</code> if the path exists and has been deleted
	 *         successfully; <code>false</code> othewise.
	 */
	public static boolean deleteDir(File _path) {
		// 1. to check whether the path exists
		if (!_path.exists()) {
			return false;
		}

		// 2. to delete the files in the path
		if (_path.isDirectory()) {
			// if _path is not a dir,files=null
			File[] files = _path.listFiles();
			File aFile;
			for (int i = 0; i < files.length; i++) {
				aFile = files[i];
				if (aFile.isDirectory()) {
					deleteDir(aFile);
				} else {
					aFile.delete();
				}
			}// endfor
		}

		// 3. to delete the path self
		return _path.delete();
	}

	/**
	 * 获取某一路径下的子文件夹
	 * 
	 * @param _dir
	 *            路径名称
	 * @return 子文件夹对象数组
	 */
	public static File[] listSubDirectories(String _dir) {
		File fDir = new File(_dir);
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};

		File[] files = fDir.listFiles(fileFilter);
		return files;
	}

	// =======================================================================
	// 文件读写操作函数

	// 读取文件的内容，返回字符串类型的文件内容
	/**
	 * 读取文件的内容，返回字符串类型的文件内容
	 * 
	 * @param _sFileName
	 *            文件名
	 * @return
	 * @throws BusinessException
	 */
	public static String readFile(String _sFileName) throws BusinessException {
		return readFile(_sFileName, FILE_WRITING_ENCODING);
	}// END: readFile()

	/**
	 * 读取文件的内容，返回字符串类型的文件内容
	 * 
	 * @param _sFileName
	 *            文件名
	 * @param _sEncoding
	 *            以指定的字符编码读取文件内容,默认为"UTF-8"
	 * @return
	 * @throws BusinessException
	 */
	public static String readFile(String _sFileName, String _sEncoding)
			throws BusinessException {
		FileReader fileReader = null;

		StringBuffer buffContent = null;
		String sLine;

		// 增加异常是对于资源的释放
		FileInputStream fis = null;
		BufferedReader buffReader = null;
		if (_sEncoding == null) {
			_sEncoding = "UTF-8";
		}

		try {
			fis = new FileInputStream(_sFileName);
			buffReader = new BufferedReader(new InputStreamReader(fis,
					_sEncoding));
			// 依次读取文件中的内容
			while ((sLine = buffReader.readLine()) != null) {
				if (buffContent == null) {
					buffContent = new StringBuffer();
				} else {
					buffContent.append("\n");
				}
				buffContent.append(sLine);
			}// end while
				// 关闭打开的字符流和文件流

			// 返回文件的内容
			return (buffContent == null ? "" : buffContent.toString());
		} catch (FileNotFoundException ex) {
			throw new BusinessException("要读取得文件没有找到(FileUtil.readFile)");
		} catch (IOException ex) {
			throw new BusinessException("读文件时错误(FileUtil.readFile)");
		} finally {
			// 增加异常时资源的释放
			try {
				if (fileReader != null)
					fileReader.close();
				if (buffReader != null)
					buffReader.close();
				if (fis != null)
					fis.close();
			} catch (Exception ex) {
			}

		}// end try
	}

	// 以指定内容_sFileContent生成新的文件_sFileName
	/**
	 * 以指定内容_sFileContent生成新的文件_sFileName
	 * 
	 * @param _sFileName
	 *            文件名
	 * @param _sFileContent
	 *            指定的内容
	 * @return
	 * @throws BusinessException
	 */
	public static boolean writeFile(String _sFileName, String _sFileContent)
			throws BusinessException {
		return writeFile(_sFileName, _sFileContent, FILE_WRITING_ENCODING);
	}// END: writeFile()

	/**
	 * 以指定内容_sFileContent生成新的文件_sFileName
	 * 
	 * @param _sFileName
	 *            文件名
	 * @param _sFileContent
	 *            指定的内容
	 * @return
	 * @throws BusinessException
	 */
	public static boolean writeFile(String _sFileName, String _sFileContent,
			String _encoding) throws BusinessException {
		return writeFile(_sFileName, _sFileContent, _encoding, false);
	}// END: writeFile()

	public static boolean writeFile(String _sFileName, String _sFileContent,
			String _sFileEncoding, boolean _bWriteUnicodeFlag)
			throws BusinessException {
		// 1.创建目录
		String sPath = extractFilePath(_sFileName);
		if (!FileUtil.pathExists(sPath)) {
			FileUtil.makeDir(sPath, true);
		}

		String sFileEncoding = _sFileEncoding == null ? FILE_WRITING_ENCODING
				: _sFileEncoding;

		boolean bRet = false;
		FileOutputStream fos = null;
		Writer outWriter = null;
		try {
			fos = new FileOutputStream(_sFileName);
			outWriter = new OutputStreamWriter(fos, sFileEncoding); // 指定编码方式
			if (_bWriteUnicodeFlag)
				outWriter.write(0xFEFF);
			outWriter.write(_sFileContent); // 写操作

			bRet = true;
		} catch (Exception ex) {
			m_oLogger.error("写文件[" + _sFileName + "]发生异常", ex);
			throw new BusinessException("写文件错误(FileUtil.writeFile)");
		} finally {
			try {
				if (outWriter != null) {
					outWriter.flush();
					outWriter.close();
				}
				if (fos != null)
					fos.close();
			} catch (Exception ex) {
			}
		}
		return bRet;
	}// END: writeFile()

	// 把指定的内容_sAddContent追加到文件_sFileName中
	/**
	 * 把指定的内容_sAddContent追加到文件_sFileName中
	 * 
	 * @param _sFileName
	 *            文件名
	 * @param _sAddContent
	 *            追加的内容
	 * @return
	 * @throws BusinessException
	 */
	public static boolean appendFile(String _sFileName, String _sAddContent)
			throws BusinessException {
		boolean bResult = false;
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(_sFileName, "rw");
			raf.seek(raf.length());
			raf.writeBytes(_sAddContent);
			bResult = true;
		} catch (Exception ex) {
			throw new BusinessException("向文件追加内容时发生异常(FileUtil.appendFile)");
		} finally {
			// 释放资源
			try {
				if (raf != null)
					raf.close();
			} catch (Exception ex) {
			}
		}
		return bResult;
	}// END: appendFile()

	/**
	 * 移动文件
	 * 
	 * @param _sSrcFile
	 *            待移动的文件
	 * @param _sDstFile
	 *            目标文件
	 * @return
	 * @throws BusinessException
	 */
	public static boolean moveFile(String _sSrcFile, String _sDstFile)
			throws BusinessException {
		return moveFile(_sSrcFile, _sDstFile, true);
	}

	/**
	 * 移动文件
	 * 
	 * @param _sSrcFile
	 *            待移动的文件
	 * @param _sDstFile
	 *            目标文件
	 * @param _bMakeDirIfNotExists
	 *            若目标路径不存在，是否创建;可缺省,默认值为true.
	 * @return
	 * @throws BusinessException
	 */
	public static boolean moveFile(String _sSrcFile, String _sDstFile,
			boolean _bMakeDirIfNotExists) throws BusinessException {
		// 1.拷贝
		copyFile(_sSrcFile, _sDstFile, _bMakeDirIfNotExists);
		// 2.删除
		deleteFile(_sSrcFile);
		return false;
	}

	/**
	 * 复制文件
	 * 
	 * @param _sSrcFile
	 *            源文件（必须包含路径）
	 * @param _sDstFile
	 *            目标文件（必须包含路径）
	 * @param _bMakeDirIfNotExists
	 *            若目标路径不存在，是否创建;可缺省,默认值为true.
	 * @return 若文件复制成功，则返回true；否则，返回false.
	 * @throws BusinessException
	 *             源文件不存在,或目标文件所在目录不存在,或文件复制失败,会抛出异常.
	 */
	public static boolean copyFile(String _sSrcFile, String _sDstFile)
			throws BusinessException {
		return copyFile(_sSrcFile, _sDstFile, true);
	}

	public static boolean copyFile(String _sSrcFile, String _sDstFile,
			boolean _bMakeDirIfNotExists) throws BusinessException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(_sSrcFile); // 若文件不存在,会抛出异常

			// 如果目录不存在，则创建目录
			try {
				fos = new FileOutputStream(_sDstFile);
			} catch (FileNotFoundException ex) {
				if (_bMakeDirIfNotExists) { // 自动创建目录
					if (!FileUtil.makeDir(FileUtil.extractFilePath(_sDstFile),
							true)) {
						throw new BusinessException("为目标文件[" + _sDstFile
								+ "]创建目录失败！");
					}
					fos = new FileOutputStream(_sDstFile);
				} else {
					throw new BusinessException("指定目标文件[" + _sDstFile
							+ "]所在目录不存在！");
				}
			}// end try

			byte buffer[] = new byte[4096];
			int bytes;
			while ((bytes = fis.read(buffer, 0, 4096)) > 0) {
				fos.write(buffer, 0, bytes);
			}// end while
		} catch (FileNotFoundException ex) {
			throw new BusinessException("要复制的原文件没有发现(FileUtil.copyFile)");
		} catch (IOException ex) {
			throw new BusinessException("复制文件时发生异常(FileUtil.copyFile)");
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (Exception ex) {
				}
			if (fis != null)
				try {
					fis.close();
				} catch (Exception ex) {
				}
		}// end try

		return true;
	}// END: copyFile()

}