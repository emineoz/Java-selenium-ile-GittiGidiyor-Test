# Java-selenium-ile-GittiGidiyor-Test

Java Selenium ile birçok test case yazarak UI Test projesi oluşturdum. Test caselerimde girilen parametrelere göre doğru çıktıyı verip vermediğinin kontrolünü gerçekleştirmesi ve raporlaması için Log4j kütüphanesini kulandım.

# Kullanılan Teknolojiler

* Java - Pojenin yazılmış olduğu kodlama dilidir.
* Selenium - Web Sitesini test etmek için kullanılan Test Otomasyon Aracıdır.
* TestNG - Test Caselerin yazılması ve çıktıların kontrollerinde kullanılan Test Yazım Aracıdır.
* Log4J - Hata sonuçlarının loglanmasını sağlar.
* Page Object Pattern -Projede kullanılan mimari yapıdır.

# Test caseler

* www.gittigidiyor.com sitesi açılır.
* Ana sayfanın açıldığı kontrol edilir.
* Login işlemi yapılır
* Email ve şifrenin doğru girilip girilmediği kontrol edilir.
* Yanlış email veya şifre girildiğinde hatanın daha belirgin görülebilmesi adına ekran görüntüsü alınır
* Giriş yapıldığında hesap adıyla kullanıcının girdiği emailin doğruluğu kontrol edilir.
* Arama kutusuna "Bilgisayar" yazılır.
* Aranan ürünle ilgili kullanıcıya sunulan uygun içeriklerin kontrolü yapılır.
* Ücretsiz kargo filtresi yapılır.
* Listenen ürünlerden ikinci sayfa sekmesine tıklanılır.
* Ürün seçilir.
* Ürün detay sayfasına gidilir.
* Ürün sepete eklenir.
* Sepetim butonuna tıklanıp o sayfaya gidilir.
* Ürünün birim fiyatı yazdırılır.
* Ürün adedi arttırılır.
* Ürünlerin tamamı silinir
* "Sepetinizde ürün bulunmamaktadır" mesajının alınıp alınmadığı kontrol edilir.

# Ekran Çıktıları

![image](https://user-images.githubusercontent.com/71029128/199696902-d1a9bb6f-3f62-4651-9c98-0b72bac579f7.png)

![image](https://user-images.githubusercontent.com/71029128/199697020-9fc79cb5-dad2-4e9c-8fae-3a757587d344.png)

![image](https://user-images.githubusercontent.com/71029128/199697273-a1080a9a-4edd-4155-9be1-f06589151b4d.png)




