package mailSenderTests.model;

import java.util.Set;

public class Letter {

	private String to;
	private String subject;
	private String text;
	private Set files;

	public Letter(){
	}

	public Letter(String to, String subject,String text,Set files){
		this.to=to;
		this.subject=subject;
		this.text=text;
		this.files=files;
	}
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set getFiles() {
		return files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		return (to != null && to.equals(((Letter) obj).to) && subject != null && subject.equals(((Letter) obj).subject));
	}
}
