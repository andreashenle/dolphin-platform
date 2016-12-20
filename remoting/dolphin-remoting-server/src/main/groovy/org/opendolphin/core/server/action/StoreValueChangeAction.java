package org.opendolphin.core.server.action;

import groovy.lang.Closure;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.opendolphin.core.comm.ValueChangedCommand;
import org.opendolphin.core.server.ServerAttribute;
import org.opendolphin.core.server.comm.ActionRegistry;

import java.util.logging.Logger;

public class StoreValueChangeAction extends DolphinServerAction {

    private static final Logger LOG = Logger.getLogger(StoreValueChangeAction.class.getName());

    public void registerIn(ActionRegistry registry) {
        registry.register(ValueChangedCommand.class, new Closure<Object>(this, this) {
            public void doCall(final ValueChangedCommand command, Object response) {
                final ServerAttribute attribute = getServerDolphin().findAttributeById(command.getAttributeId());
                if (DefaultGroovyMethods.asBoolean(attribute)) {
                    if ((attribute.getValue() != null || command.getOldValue() != null) && !attribute.getValue().equals(command.getOldValue())) {
                        LOG.warning("S: updating attribute with id '" + command.getAttributeId() + "' to new value '" + command.getNewValue() + "' even though its old command value '" + command.getOldValue() + "' does not conform to the old value of '" + attribute.getValue() + "'. Client overrules server.");
                    }

                    attribute.silently(new Runnable() {
                        @Override
                        public void run() {
                            attribute.setValue(command.getNewValue());
                        }

                    });
                } else {
                    LOG.severe("S: cannot find attribute with id '" + command.getAttributeId() + "' to change value from '" + command.getOldValue() + "' to '" + command.getNewValue() + "'.");
                }

            }

        });
    }
}
