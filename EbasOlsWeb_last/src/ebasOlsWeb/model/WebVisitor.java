package ebasOlsWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="web_visitor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WebVisitor {
	
	@Column(name="visitor_count",nullable=false)
	private int	visitor_count;// numeric NOT NULL

	public int getVisitor_count() {
		return visitor_count;
	}

	public void setVisitor_count(int visitor_count) {
		this.visitor_count = visitor_count;
	}
	
	
}
