import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class priceScraper {
    public static void main(String[] args){
        // SCANNER TO BE ADDED TO TAKE URL FROM USER
        final String url = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=shrek+crocs&_sacat=0&LH_Sold=1&_fsrp=1&LH_Complete=1&rt=nc&LH_PrefLoc=1";

        try {
            final Document test = Jsoup.connect(url).get();
            Elements soldItems = test.select(".s-item__info.clearfix"); //SCRAPES ALL ITEMS ON PAGE AND ADDS IT TO THE ELEMENTS ARRAY
            //FOR LOOP WILL GO THROUGH AND FILTER OUT FOR DESIRED DATA
            for(Element sp:soldItems){
                String soldPrice = sp.select(" .s-item__price > .POSITIVE").text();// FOR PRICE
                String priceStrip = soldPrice.replace("$", "").replace(",", ""); // REMOVES $ AND , IN THE CASE THE WE CHOSE TO WORK WITH DATA
                System.out.println(priceStrip);
                }
        }
        // NEEDS TO BE REFINED. NOT SURE OF SCOPE
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
