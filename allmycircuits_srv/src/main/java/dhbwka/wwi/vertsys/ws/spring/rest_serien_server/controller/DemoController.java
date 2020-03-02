package dhbwka.wwi.vertsys.ws.spring.rest_serien_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Episode;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Season;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Series;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.repository.SeasonRepository;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.repository.SeriesRepository;

/**
 * DemoController
 */
@RestController
@RequestMapping(value = "/demo", produces = "application/json")
public class DemoController {
    
    @Autowired
    SeriesRepository SeriesRepo;

    @Autowired
    SeasonRepository SeasonRepo;

    @RequestMapping(value = "/create", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Series> createDemoData() {
        List<Series> allSeries = null;
        allSeries = this.createSeriesData();

        return new ResponseEntity<Series>(HttpStatus.OK);
    }

    private List<Series> createSeriesData() {
        List<Series> allSeries = null;
        Series series;

        for (Series ser : SeriesRepo.findAll()) {
            SeriesRepo.delete(ser);
        }

        for (Season seas : SeasonRepo.findAll()) {
            SeasonRepo.delete(seas);
        }

        // Serie: Akte X
        //series = new Series(new Long(1), "Akte X", "Mystery", "USA / Canada", 1993, 2018, 11, 218);
        series = new Series("Akte X", "Mystery", "USA / Canada", 1993, 2018, 11, 218);
        SeriesRepo.save(series);
        SeasonRepo.save(new Season(series, 1, 1993, new String[]{"Gezeichnet", "Die Warnung", "Das Nest", "Signale", "Der Teufel von Jersey", "Schatten", "Die Maschine", "Eis", "Besessen", "Gefallener Engel", "Eve", "Feuer", "Die Botschaft", "Verlockungen", "Lazarus", "Ewige Jugend", "Täuschungsmanöver", "Der Wunderheiler", "Verwandlungen", "Der Kokon", "Ein neues Nest", "Wiedergeboren", "Roland", "Das Labor"}));
        SeasonRepo.save(new Season(series, 2, 1994, new String[]{"Kontakt", "Der Parsit", "Blut", "Schlaflos", "Unter Kontrolle - Teil 1", "Seilbahn zu den Sternen - Teil 2", "Drei", "An der Grenze", "Der Vulkan", "Rotes Museum", "Excelsis Dei", "Böse geboren", "Todestrieb", "Satan", "Frische Knochen", "Die Kolonie - Teil 1", "Die Kolonie - Teil 2", "Sophie", "Totenstille", "Der Zirkus", "Heilige Asche", "Verseucht", "Das Experiment", "Unsere kleine Stadt", "Anasazi - Teil 1"}));
        SeasonRepo.save(new Season(series, 3, 1995, new String[]{"Das Ritual – Teil 2", "Verschwörung des Schweigens – Teil 3", "Blitzschlag", "Der Hellseher", "Die Liste", "Fett", "Der zweite Körper", "Parallele", "Die Autopsie – Teil 1", "Der Zug – Teil 2", "Offenbarung", "Krieg der Koprophagen", "Energie", "Groteske", "Der Feind – Teil 1", "Der Feind – Teil 2", "Mein Wille sei dein Wille", "Der Fluch", "Höllengeld", "Andere Wahrheiten", "Heimsuchung", "Der See", "Ferngesteuert", "Der Tag steht schon fest – Teil 1"}));
        SeasonRepo.save(new Season(series, 4, 1996, new String[]{"Herrenvolk – Teil 2", "Blutschande", "Teliko", "Unruhe", "Rückkehr der Seelen", "Hexensabbat", "Gedanken des geheimnisvollen Rauchers", "Tunguska – Teil 1", "Tunguska – Teil 2", "Die Sammlung", "Der Chupacabra", "Leonard Betts", "Mutterkorn", "Memento Mori", "Der Golem", "Unsichtbar", "Tempus Fugit – Teil 1", "Tempus Fugit – Teil 2", "Rückkehr aus der Zukunft", "Ein unbedeutender Niemand", "Der Pakt mit dem Teufel", "Todes-Omen", "Dämonen", "Gethsemane"}));
        SeasonRepo.save(new Season(series, 5, 1997, new String[]{"Redux – Teil 1", "Redux – Teil 2", "Die unüblichen Verdächtigen", "Vom Erdboden verschluckt", "Der große Mutato", "Emily – Teil 1", "Emily – Teil 2", "Kitsunegari", "Die Wurzeln des Bösen", "Ein Spiel", "Kill Switch", "Böses Blut", "Cassandra – Teil 1", "Cassandra – Teil 2", "Gute Patrioten", "Das innere Auge", "Alle Seelen", "Die Pine-Bluff-Variante", "Folie a Deux", "Das Ende"}));
        SeasonRepo.save(new Season(series, 6, 1998, new String[]{"Der Anfang", "Die Fahrt", "Im Bermuda-Dreieck", "Dreamland – Teil 1", "Dreamland – Teil 2", "Die Geister, die ich rief", "Zeit der Zärtlichkeit", "Der Regenmacher", "S.R. 819", "Tithonus", "Zwei Väter – Teil 1", "Ein Sohn – Teil 2", "Aqua Mala", "Montag", "Arkadien", "Alpha", "Trevor", "Milagro", "Ex", "Suzanne", "Sporen", "Artefakte"}));
        SeasonRepo.save(new Season(series, 7, 1999, new String[]{"Böse Zeichen – Teil 1", "Tausend Stimmen – Teil 2", "Hunger", "Millennium", "Masse mal Beschleunigung", "Das Glück des Henry Weems", "Tor zur Hölle", "Der unglaubliche Maleeni", "Schlangen", "Alte Seelen – Teil 1", "Sternenlicht – Teil 2", "Vollmond", "Game Over", "Zauberstaub", "Cobra", "Zerbrochene Spiegel", "Augenblicke", "Nikotin", "Hollywood", "27.000.000 : 1", "Drei Wünsche", "Alles beginnt in Oregon – Teil 1"}));
        SeasonRepo.save(new Season(series, 8, 2000, new String[]{"Verschwunden – Teil 2", "Gibson Praise – Teil 3", "Klauen und Zähne", "Gesteinigt", "Billy", "Rückwärts", "Via Negativa", "Fenster der Seele", "Schlaues Metall", "Hier und nicht hier", "Der Seelenesser", "Underground", "Frucht des Leibes", "Es ist zu spät – Teil 1", "Lebendig tot – Teil 2", "Drei Worte", "Feuer und Asche", "Sie kommen", "Augenlicht", "Einer von vielen – Teil 1", "William – Teil 2"}));
        SeasonRepo.save(new Season(series, 9, 2001, new String[]{" Unter Wasser – Teil 1", "Adam und Eva – Teil 2", "Daemonicus", "4-D", "Der Herr der Fliegen", "Schattenmann", "Desaparecido", "Häutungen", "Drohungen – Teil 1", "Die Prophezeiung – Teil 2", "Audrey", "Der Mörder in mir", "Sechs und neun", "Unter dem Bett", "Helden", "Zum Wohle des Kindes", "Erlösung", "Die perfekte Familie", "Die Wahrheit – Teil 1", "Die Wahrheit – Teil 2"}));
        SeasonRepo.save(new Season(series, 10, 2017, new String[]{"Der Kampf", "Gründer-Mutation", "Mulder und Scully gegen das Wer-Monster", "Heimat", "Babylon", "Der Kampf II"}));
        SeasonRepo.save(new Season(series, 11, 2018, new String[]{"Der Kampf III", "Dieses Leben, jenes Leben", "Galgenmännchen", "Der Mandela-Effekt", "Ghouli", "Kätzchen", "Rm9sbG93ZXJz", "Das Tor zur Hölle", "Nichts währt ewig", "Der Kampf IV"}));

        // Serie: Star Trek – The Original Series
        //series = new Series(new Long(2), "Star Trek – The Original Series", "Sci-Fi", "USA", 1966, 1969, 3, 79);
        series = new Series("Star Trek – The Original Series", "Sci-Fi", "USA", 1966, 1969, 3, 79);
        SeriesRepo.save(series);
        
        SeasonRepo.save(new Season(series, 1, 1966, new String[]{"Das Letzte seiner Art", "Der Fall Charlie", "Die Spitze des Eisberges", "Implosion in der Spirale", "Kirk : 2 = ?", "Die Frauen des Mr Mudd", "Der alte Traum", "Miri, ein Kleinling", "Der Zentralnervensystemmanipulator", "Pokerspiele", "Talos IV – Tabu – Teil 1", "Talos IV – Tabu – Teil 2", "Kodos, der Henker", "Spock unter Verdacht", "Landeurlaub", "Notlandung auf Galileo 7", "Tödliche Spiele auf Gothos", "Ganz neue Dimensionen", "Morgen ist gestern", "Kirk unter Anklage", "Landru und die Ewigkeit", "Der schlafende Tiger", "Krieg der Computer", "Falsche Paradiese", "Horta rettet ihre Kinder", "Kampf um Organia", "Auf Messers Schneide", "Griff in die Geschichte", "Spock außer Kontrolle"}));
        SeasonRepo.save(new Season(series, 2, 1967, new String[]{"Weltraumfieber", "Der Tempel des Apoll", "Ich heiße Nomad", "Ein Parallel-Universum", "Die Stunde der Erkenntnis", "Planeten-Killer", "Das Spukschloss im Weltall", "Der dressierte Herrscher", "Metamorphose", "Reise nach Babel", "Im Namen des jungen Tiru", "Wie schnell die Zeit vergeht", "Tödliche Wolken", "Der Wolf im Schafspelz", "Kennen Sie Tribbles?", "Meister der Sklaven", "Epigonen", "Das Loch im Weltraum", "Der erste Krieg", "Geist sucht Körper", "Schablonen der Gewalt", "Stein und Staub", "Das Jahr des roten Vogels", "Computer M5", "Brot und Spiele", "Ein Planet, genannt Erde"}));
        SeasonRepo.save(new Season(series, 3, 1968, new String[]{"Spocks Gehirn", "Die unsichtbare Falle", "Der Obelisk", "Kurs auf Markus 12", "Die fremde Materie", "Wildwest im Weltraum", "Das Gleichgewicht der Kräfte", "Der verirrte Planet", "Das Spinnennetz", "Platons Stiefkinder", "Was summt denn da?", "Der Plan der Vianer", "Brautschiff Enterprise", "Wen die Götter zerstören", "Bele jagt Lokai", "Fast unsterblich", "Gefährliche Planetengirls", "Strahlen greifen an", "Planet der Unsterblichen", "Die Reise nach Eden", "Die Wolkenstadt", "Seit es Menschen gibt", "Portal in die Vergangenheit", "Gefährlicher Tausch"}));

        return allSeries;
    }
}