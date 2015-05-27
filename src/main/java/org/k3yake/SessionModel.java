package org.k3yake;

/**
 * Created by katsuki on 15/05/28.
 */
import org.apache.wicket.Application;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.request.cycle.RequestCycle;

public class SessionModel extends AbstractReadOnlyModel<String>
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see org.apache.wicket.model.AbstractReadOnlyModel#getObject()
     */
    @Override
    public String getObject()
    {
        final String msg;
        String sessionId = Application.get()
                .getSessionStore()
                .getSessionId(RequestCycle.get().getRequest(), false);
        if (sessionId == null)
        {
            msg = "no concrete session is created yet (only a volatile one)";
        }
        else
        {
            msg = "a session exists for this client, with session id " + sessionId;
        }
        return msg;
    }

}
