package itaf.framework.workflow.service;

import java.util.List;
import java.util.Map;

public interface TraceService {
	public List<Map<String, Object>> traceProcess(String processInstanceId)
			throws Exception;
}
