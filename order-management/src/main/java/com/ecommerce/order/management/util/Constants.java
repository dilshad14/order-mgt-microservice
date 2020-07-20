package com.ecommerce.order.management.util;

public class Constants {
	private Constants() {
		// to beat instantiation
	}

	public static final String NO_DATA_FOUND = "No Data Found";
	public static final String GENERIC_ERROR = "General Error";
	public static final String GENERIC_ERROR_MSG = "A General Error has occured, please contact support";
	public static final String VALIDATION_ERROR = "Validation Failed";
	//public static final String REMOTE_SERVICE_ERROR = "Remote Service Error";
	public static final String REMOTE_SERVICE_ERROR = "An error has occure at one of the microservice required for this operation, Please contact support";

	public static class Validation {
		private Validation() {
			// to beat instantiation
		}

		public static final String ORDER_ID_INVALID = "Invalid Order ID";
		public static final String CUSTOMER_NAME_INVALID = "Invalid Customer Name";
		public static final String ORDER_DATE_INVALID = "Invalid Order Date";
		public static final String ORDER_PRODUCTS_INVALID = "Invalid Products";
		public static final String ORDER_TOTAL_INVALID = "Invalid Total";
		public static final String ORDER_SHIPPING_ADDRESS_INVALID = "Invalid Shipping Address";
	}
}
