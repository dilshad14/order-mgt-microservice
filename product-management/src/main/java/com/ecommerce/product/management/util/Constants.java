package com.ecommerce.product.management.util;

public class Constants {
	private Constants() {
		// to beat instantiation
	}

	public static final String NO_DATA_FOUND = "No Data Found";
	public static final String GENERIC_ERROR = "An error has occure, Please contact support";

	public static class Validation {
		private Validation() {
			// to beat instantiation
		}
		public static final String ORDER_ID_INVALID = "Invalid Order ID";
		public static final String PRODUCT_ID_INVALID = "Invalid Product ID ";
		public static final String PRODUCT_NAME_INVALID = "Invalid Product Name";
		public static final String PRODUCT_QTY_INVALID = "Invalid Product Quantity";
	}
}
