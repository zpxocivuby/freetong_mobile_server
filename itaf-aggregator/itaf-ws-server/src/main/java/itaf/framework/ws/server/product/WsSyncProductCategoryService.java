package itaf.framework.ws.server.product;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.product.dto.BzProductCategoryDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.product")
public interface WsSyncProductCategoryService {

	public WsPageResult<BzProductCategoryDto> syncPager2Client(
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

}
