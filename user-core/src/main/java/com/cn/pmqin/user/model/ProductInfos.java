/**
 * 
 */
package com.cn.pmqin.user.model;
/** 
* @author : pmqin
* @date   : 2016年8月1日 下午12:37:38 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class ProductInfos {

	
	private int ID;
	
	private String names;
	
	private int productCateID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public int getProductCateID() {
		return productCateID;
	}

	public void setProductCateID(int productCateID) {
		this.productCateID = productCateID;
	}
}
