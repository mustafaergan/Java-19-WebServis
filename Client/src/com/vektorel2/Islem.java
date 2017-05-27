package com.vektorel2;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.vektorel.HesapMakinasiServiceLocator;

public class Islem {
	
	public static void main(String[] args) {
		HesapMakinasiServiceLocator hesap = new HesapMakinasiServiceLocator();
		int veri = 0;
		try {
			veri = hesap.getHesapMakinasi().toplama(10, 20);
			System.out.println(veri);
			veri = hesap.getHesapMakinasi().cikarma(10, 20);
			System.out.println(veri);
		} catch (RemoteException | ServiceException e) {
			e.printStackTrace();
		}
	}

}
