/**
 * @Author: 刘聪
 * @descripe:BaseMethodInterfaces.java
 * @gitconfig:   
 * @Date: Created in 2018-03-21 下午9:38:47
 * @Modified By:
 */
package com.common;

import java.util.List;
import java.util.Map;

public interface BaseMethodInterfaces<T> {
	public abstract List<T> list(Map<String, Object> params); 
	public abstract T queryById(int id);
	public abstract int deleteById(int id);
	public abstract int updateById(int id);
}
