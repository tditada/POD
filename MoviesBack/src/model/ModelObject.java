package model;

import java.io.IOException;
import java.util.List;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

public class ModelObject implements DataSerializable  {
	
	private String title;
	private int year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private Double metascore;
	private Double imdbRating;
	private Long imdbVotes;
	private String imdbId;
	private String type;
	private Integer tomatoMeter;
	private Double tomatoRating;
	private Integer tomatoReviews;
	private Integer tomatoFresh;
	private Integer tomatoRotten;
	private String tomatoConsensus;
	private Integer tomatoUserMeter;
	private Double tomatoUserRating;
	private Integer tomatoUserReviews;
	private String dvd;
	private String boxOffice;
	private String production;
	private String website;
	private boolean response;
	
	
	@Override
	public void readData(ObjectDataInput in) throws IOException {
		this.title = in.readUTF();
		this.year = in.readInt();
		this.rated = in.readUTF();
		this.released = in.readUTF();
		this.runtime = in.readUTF();
		this.genre = in.readUTF();
		this.director = in.readUTF();
		this.writer = in.readUTF();
		this.actors = in.readUTF();
		this.plot = in.readUTF();
		this.language = in.readUTF();
		this.country = in.readUTF();
		this.awards = in.readUTF();
		this.poster = in.readUTF();
		this.metascore = in.readDouble();
		this.imdbRating = in.readDouble();
		this.imdbVotes = in.readLong();
		this.imdbId = in.readUTF();
		this.type = in.readUTF();
		this.tomatoMeter = in.readInt();
		this.tomatoRating = in.readDouble();
		this.tomatoReviews = in.readInt();
		this.tomatoFresh = in.readInt();
		this.tomatoRotten = in.readInt();
		this.tomatoConsensus = in.readUTF();
		this.tomatoUserMeter = in.readInt();
		this.tomatoUserRating = in.readDouble();
		this.tomatoUserReviews = in.readInt();
		this.dvd = in.readUTF();
		this.boxOffice = in.readUTF();
		this.production = in.readUTF();
		this.website = in.readUTF();
		this.response = in.readBoolean();
		
	}
	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
//		out.readUTF();
//		out.readInt();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readDouble();
//		out.readDouble();
//		out.readLong();
//		out.readUTF();
//		out.readUTF();
//		out.readInt();
//		out.readDouble();
//		out.readInt();
//		out.readInt();
//		out.readInt();
//		out.readUTF();
//		out.readInt();
//		out.readDouble();
//		out.readInt();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readUTF();
//		out.readBoolean();
		
	}
	public String getTitle() {
		return title;
	}
	public int getYear() {
		return year;
	}
	public String getRated() {
		return rated;
	}
	public String getReleased() {
		return released;
	}
	public String getRuntime() {
		return runtime;
	}
	public String getGenre() {
		return genre;
	}
	public String getDirector() {
		return director;
	}
	public String getWriter() {
		return writer;
	}
	public String getActors() {
		return actors;
	}
	public String getPlot() {
		return plot;
	}
	public String getLanguage() {
		return language;
	}
	public String getCountry() {
		return country;
	}
	public String getAwards() {
		return awards;
	}
	public String getPoster() {
		return poster;
	}
	public Double getMetascore() {
		return metascore;
	}
	public Double getImdbRating() {
		return imdbRating;
	}
	public Long getImdbVotes() {
		return imdbVotes;
	}
	public String getImdbId() {
		return imdbId;
	}
	public String getType() {
		return type;
	}
	public Integer getTomatoMeter() {
		return tomatoMeter;
	}
	public Double getTomatoRating() {
		return tomatoRating;
	}
	public Integer getTomatoReviews() {
		return tomatoReviews;
	}
	public Integer getTomatoFresh() {
		return tomatoFresh;
	}
	public Integer getTomatoRotten() {
		return tomatoRotten;
	}
	public String getTomatoConsensus() {
		return tomatoConsensus;
	}
	public Integer getTomatoUserMeter() {
		return tomatoUserMeter;
	}
	public Double getTomatoUserRating() {
		return tomatoUserRating;
	}
	public Integer getTomatoUserReviews() {
		return tomatoUserReviews;
	}
	public String getDvd() {
		return dvd;
	}
	public String getBoxOffice() {
		return boxOffice;
	}
	public String getProduction() {
		return production;
	}
	public String getWebsite() {
		return website;
	}
	public boolean isResponse() {
		return response;
	}
	
}
