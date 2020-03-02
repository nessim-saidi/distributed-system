package dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Schlüsselwerte für eine Serienstaffel.
 */
public class SeasonId implements Serializable {
    //private String series = "";
    private Long series;
    private int seasonNumber = -1;
    
    public SeasonId() {
    }
    
    public SeasonId(Long series, int seasonNumber) {
        this.series = series;
        this.seasonNumber = seasonNumber;
    }

    public Long getSeries() {
        return series;
    }
    
    public void setSeries(Long series) {
        this.series = series;
    }
    
    public int getSeasonNumber() {
        return seasonNumber;
    }
    
    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.series);
        hash = 37 * hash + this.seasonNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SeasonId other = (SeasonId) obj;
        if (this.seasonNumber != other.seasonNumber) {
            return false;
        }
        if (!Objects.equals(this.series, other.series)) {
            return false;
        }
        return true;
    }

}
