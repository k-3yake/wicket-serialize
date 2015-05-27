package org.k3yake;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import java.lang.Integer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private int linkClickCount = 0;

	public HomePage(){
		add(new Label("message", new SessionModel()));

		final Link actionLink = new Link("actionLink"){
			@Override
			public void onClick(){
				linkClickCount++;
			}
		};
		add(actionLink);
		actionLink.add(new Label("linkClickCount", new PropertyModel<Integer>(this,"linkClickCount")));
		final TextField<String> field = new TextField<String>("textfield", new Model<String>());
		StatelessForm<?> statelessForm = new StatelessForm("statelessform")	{
			@Override
			protected void onSubmit(){
				info("Submitted text: " + field.getDefaultModelObject() + ", link click count: " +	linkClickCount);
			}
		};
		statelessForm.add(field);
		add(statelessForm);
		add(new FeedbackPanel("feedback"));
	}

	public int getLinkClickCount(){		return linkClickCount;	}

	public void setLinkClickCount(int linkClickCount){		this.linkClickCount = linkClickCount;	}
}
