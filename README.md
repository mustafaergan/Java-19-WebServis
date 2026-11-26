# Java 19 Grubu - Web Servis Örnekleri

Vektörel eğitimindeki "Java 19" grubunda web servislere giriş için yazılan örnekler: Apache Axis ile bir SOAP
hesap makinesi servisi ve istemcisi, Jersey (JAX-RS) ile JSON dönen basit bir REST kişi servisi.

> **Not:** Bu depo 2017 yılında eğitim amaçlı yazıldı ve artık güncellenmiyor. Bağımlılıkları eskidir ve
> bilinen güvenlik açıkları içerir; üretimde kullanmayın.

## İçerik

| Klasör | Ne yapar |
|---|---|
| `Sunucu` | `HesapMakinasi` sınıfını (toplama, çıkarma, çarpma, bölme) Axis ile SOAP servisi olarak yayınlar; WSDL `WebContent/wsdl` altında |
| `Client` | WSDL'den üretilmiş Axis istemci sınıfları ve servisi çağıran `com.vektorel2.Islem` |
| `KullaniciServisi` | Jersey 1.x ile `/rest/person` altında kişi ekleme, getirme, güncelleme, silme ve toplama uçları; veriler bellekte bir listede tutulur. `toplama.html` ve `deneme.html` bu uçlara form gönderir |
| `Selamla` | Tek sınıflık (`Degistir`) başlangıç web projesi |

## Teknolojiler

- Java 8, Servlet 3.0, Tomcat 9 (Eclipse sunucu ayarına göre)
- SOAP: Apache Axis 1.x, JAX-RPC (jar'lar `WEB-INF/lib` altında)
- REST (`KullaniciServisi`, Maven): Jersey 1.8 (`jersey-server`, `jersey-json`), Gson 2.8.9

## Çalıştırma

- `KullaniciServisi` bir Maven projesidir: Eclipse'e "Existing Maven Projects" olarak alın ya da `mvn package` ile
  oluşan `war` dosyasını bir Tomcat'e kurun. Uçlar `http://localhost:<port>/KullaniciServisi/rest/person/...`
  adresinde açılır.
- `Sunucu`, `Client` ve `Selamla` Maven kullanmayan Eclipse "Dynamic Web Project"leridir. Eclipse proje dosyaları
  depoda olmadığı için Eclipse'te aynı adla yeni bir Dynamic Web Project açıp `src` ve `WebContent` klasörlerini
  içine kopyalayın, sonra projeyi Tomcat'e ekleyin.
- Örneklerde Tomcat portu `8088` olarak yazılmıştır (`toplama.html`, `deneme.html` ve
  `Client/src/com/vektorel/HesapMakinasiServiceLocator.java`). Farklı bir port kullanıyorsanız bu adresleri değiştirin.
- SOAP istemcisini denemek için önce `Sunucu`yu çalıştırın, ardından `Client` içindeki `com.vektorel2.Islem` sınıfını çalıştırın.
