package com.garyluoex.project;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.usb.UsbDevice;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbServices;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws UsbException, UnsupportedEncodingException, UsbDisconnectedException {
		UsbServices services = UsbHostManager.getUsbServices();
		UsbHub rootHub = services.getRootUsbHub();
		List<UsbDevice> devices = rootHub.getAttachedUsbDevices();
		System.out.println(devices.get(0).getUsbDeviceDescriptor().idVendor());
	}
}