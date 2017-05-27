package com.vektorel;

public class HesapMakinasiProxy implements com.vektorel.HesapMakinasi {
  private String _endpoint = null;
  private com.vektorel.HesapMakinasi hesapMakinasi = null;
  
  public HesapMakinasiProxy() {
    _initHesapMakinasiProxy();
  }
  
  public HesapMakinasiProxy(String endpoint) {
    _endpoint = endpoint;
    _initHesapMakinasiProxy();
  }
  
  private void _initHesapMakinasiProxy() {
    try {
      hesapMakinasi = (new com.vektorel.HesapMakinasiServiceLocator()).getHesapMakinasi();
      if (hesapMakinasi != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hesapMakinasi)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hesapMakinasi)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hesapMakinasi != null)
      ((javax.xml.rpc.Stub)hesapMakinasi)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.vektorel.HesapMakinasi getHesapMakinasi() {
    if (hesapMakinasi == null)
      _initHesapMakinasiProxy();
    return hesapMakinasi;
  }
  
  public int bolme(int veri1, int veri2) throws java.rmi.RemoteException{
    if (hesapMakinasi == null)
      _initHesapMakinasiProxy();
    return hesapMakinasi.bolme(veri1, veri2);
  }
  
  public int toplama(int veri1, int veri2) throws java.rmi.RemoteException{
    if (hesapMakinasi == null)
      _initHesapMakinasiProxy();
    return hesapMakinasi.toplama(veri1, veri2);
  }
  
  public int carpma(int veri1, int veri2) throws java.rmi.RemoteException{
    if (hesapMakinasi == null)
      _initHesapMakinasiProxy();
    return hesapMakinasi.carpma(veri1, veri2);
  }
  
  public int cikarma(int veri1, int veri2) throws java.rmi.RemoteException{
    if (hesapMakinasi == null)
      _initHesapMakinasiProxy();
    return hesapMakinasi.cikarma(veri1, veri2);
  }
  
  
}