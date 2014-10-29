package br.ufrn.controlers;

import context.arch.widget.Widget;

public class MyWidget extends Widget implements Cloneable{

	public MyWidget(String id, String widgetClassName) {
		super(id, widgetClassName);
		// TODO Auto-generated constructor stub
	}

	public MyWidget(int port, String id, String widgetClassName) {
		super(port, id, widgetClassName);
		// TODO Auto-generated constructor stub
	}

	public MyWidget(String id, boolean storageFlag, String widgetClassName) {
		super(id, storageFlag, widgetClassName);
		// TODO Auto-generated constructor stub
	}

	public MyWidget(int port, String id, String widgetClassName,
			boolean storageFlag) {
		super(port, id, widgetClassName, storageFlag);
		// TODO Auto-generated constructor stub
	}

	public MyWidget(String clientClass, String serverClass, int serverPort,
			String encoderClass, String decoderClass, String storageClass,
			String id, String widgetClassName) {
		super(clientClass, serverClass, serverPort, encoderClass, decoderClass,
				storageClass, id, widgetClassName);
		// TODO Auto-generated constructor stub
	}

	public MyWidget(String clientClass, String serverClass, int serverPort,
			String encoderClass, String decoderClass, boolean storageFlag,
			String id, String widgetClassName) {
		super(clientClass, serverClass, serverPort, encoderClass, decoderClass,
				storageFlag, id, widgetClassName);
		// TODO Auto-generated constructor stub
	}
	
	public MyWidget clone(){
		try {
			return (MyWidget) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
