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
        List<Artist> artists = datasource.queryArtists();
        if(artists==null)
        {
            System.out.println("No artists");
            return;
        }
        for(Artist artist:artists)
        {
            System.out.println("ID= "+artist.getId()+", Name= "+artist.getName());
        }
        datasource.close();
    }

}

