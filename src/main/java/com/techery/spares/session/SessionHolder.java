package com.techery.spares.session;

import com.techery.spares.utils.KeyValueStorage;

import de.greenrobot.event.EventBus;

public class SessionHolder<SESSION_CLASS> {
    private static String SESSION_KEY = "SESSION_KEY";

    public interface Events {
        public class SessionChanged {

        }

        public class SessionCreated<SESSION_CLASS> extends SessionChanged {
            private final SESSION_CLASS session;

            public SessionCreated(SESSION_CLASS session) {
                this.session = session;
            }

            public SESSION_CLASS getSession() {
                return session;
            }
        }

        public class SessionDestroyed  extends SessionChanged {

        }
    }

    private final Class<SESSION_CLASS> typeClass;
    private final KeyValueStorage storage;
    private final EventBus eventBus;

    public SessionHolder(KeyValueStorage storage, Class<SESSION_CLASS> cls, EventBus bus) {
        this.typeClass = cls;
        this.storage = storage;
        this.eventBus = bus;
    }

    public void saveSession(SESSION_CLASS session) {
        this.storage.putObject(SESSION_KEY, session);
        this.eventBus.post(new Events.SessionCreated<SESSION_CLASS>(session));
    }

    public void destroySession() {
        this.storage.putObject(SESSION_KEY, null);
        this.eventBus.post(new Events.SessionDestroyed());
    }

    public SESSION_CLASS getActiveSession() {
        return this.storage.getObject(SESSION_KEY, this.typeClass);
    }

    public boolean hasActiveSession() {
        return getActiveSession() != null;
    }
}
