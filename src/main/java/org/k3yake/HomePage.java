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
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** click count for Link. */
	private int linkClickCount = 0;

	/**
	 * Construct.
	 */
	public HomePage()
	{
		add(new Label("message", new SessionModel()));
		//add(new BookmarkablePageLink<>("indexLink", Index.class));

		// Action link counts link clicks
		final Link actionLink = new Link("actionLink")
		{
			@Override
			public void onClick()
			{
				linkClickCount++;
			}
		};
		add(actionLink);
		actionLink.add(new Label("linkClickCount", new PropertyModel<Integer>(this,
				"linkClickCount")));

		final TextField<String> field = new TextField<String>("textfield", new Model<String>());

		StatelessForm<?> statelessForm = new StatelessForm("statelessform")
		{
			/**
			 * @see org.apache.wicket.markup.html.form.Form#onSubmit()
			 */
			@Override
			protected void onSubmit()
			{
				info("Submitted text: " + field.getDefaultModelObject() + ", link click count: " +
						linkClickCount);
			}
		};
		statelessForm.add(field);
		add(statelessForm);
		add(new FeedbackPanel("feedback"));
	}

	/**
	 * Gets linkClickCount.
	 *
	 * @return linkClickCount
	 */
	public int getLinkClickCount()
	{
		return linkClickCount;
	}

	/**
	 * Sets linkClickCount.
	 *
	 * @param linkClickCount
	 *            linkClickCount
	 */
	public void setLinkClickCount(int linkClickCount)
	{
		this.linkClickCount = linkClickCount;
	}
}
