import com.HPcow.model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open())
        {
            System.out.println("Can't open dataSource!");
            return;
        }
        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_ASC);
        if(artists==null)
        {
            System.out.println("No artists");
            return;
        }
        for(Artist artist:artists)
        {
            System.out.println("ID= "+artist.getId()+", Name= "+artist.getName());
        }

        try{
            List<String> albumsForArtist = datasource.queryAlbumsForArtist("Iron Maiden",Datasource.ORDER_BY_DESC);
            for (String album : albumsForArtist) {
                System.out.println(album);
            }
        }catch(NullPointerException e){
            System.out.println("opps"+e.getMessage());
        }

        datasource.close();
    }

}

