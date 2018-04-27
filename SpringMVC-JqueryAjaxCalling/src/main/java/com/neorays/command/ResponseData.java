package com.neorays.command;

	public class ResponseData {
		private String status;
		private Object data;
		
		public ResponseData(){
			
		}
		
		public ResponseData(String status, Object data){
			this.status = status;
			this.data = data;
		}
	 
		public String getStatus() {
			return status;
		}
	 
		public void setStatus(String status) {
			this.status = status;
		}
	 
		public Object getData() {
			return data;
		}
	 
		public void setData(Object data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "ResponseData [status=" + status + ", data=" + data + "]";
		}
		
	}
