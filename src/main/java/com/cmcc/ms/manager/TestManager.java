package com.cmcc.ms.manager;

import com.cmcc.ms.vo.TestVO;

/**
 * 
 * @author chiwei
 * 将多个service共用的业务逻辑下沉到manager层，service依赖manager
 */
public interface TestManager {
	
	/**
	 * 下沉的一个业务方法
	 * @param args
	 * @return
	 */
	public TestVO testFun(long args);
	
}
