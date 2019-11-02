/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;

/**
 *
 * @author Jonkke
 */
public class StatisticsTest {
        Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void pelaajaKurriLoytyyListalta() {
        Player p = stats.search("Kurri");
        assertEquals(p.getName(), "Kurri");
    }
    
    @Test
    public void pelaajaSelanneEiLoydyListalta() {
        Player p = stats.search("Selanne");
        assertNull(p);
    }
    
    @Test
    public void tiimiEDMsisaltaaOikeatPelaajat() {
        List<Player> pelaajat = stats.team("EDM");
        pelaajat.forEach(p -> assertEquals("EDM", p.getTeam()));
    }
    
    @Test
    public void topScorersPalauttaaOikeanMaaranPelaajia() {
        List<Player> pelaajat = stats.topScorers(1);
        assertEquals(2, pelaajat.size());
    }
    
    @Test
    public void pelaajallaGretzkyEnitenPisteita() {
        List<Player> pelaajat = stats.topScorers(0);
        assertEquals("Gretzky", pelaajat.get(0).getName());
    }
    
}
