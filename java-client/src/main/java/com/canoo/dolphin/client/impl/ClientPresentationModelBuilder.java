package com.canoo.dolphin.client.impl;

import com.canoo.dolphin.impl.AbstractPresentationModelBuilder;
import com.canoo.dolphin.impl.PlatformConstants;
import org.opendolphin.core.Tag;
import org.opendolphin.core.client.ClientAttribute;
import org.opendolphin.core.client.ClientDolphin;
import org.opendolphin.core.client.ClientPresentationModel;

import java.util.ArrayList;
import java.util.List;

public class ClientPresentationModelBuilder extends AbstractPresentationModelBuilder<ClientPresentationModel> {

    private final List<ClientAttribute> attributes = new ArrayList<>();
    private final ClientDolphin dolphin;

    public ClientPresentationModelBuilder(ClientDolphin dolphin) {
        this.dolphin = dolphin;
        attributes.add(new ClientAttribute(PlatformConstants.SOURCE_SYSTEM, PlatformConstants.SOURCE_SYSTEM_CLIENT));
    }

    @Override
    public ClientPresentationModelBuilder withAttribute(String name) {
        attributes.add(new ClientAttribute(name));
        return this;
    }

    @Override
    public ClientPresentationModelBuilder withAttribute(String name, Object value) {
        attributes.add(new ClientAttribute(name, value));
        return this;
    }

    @Override
    public ClientPresentationModelBuilder withAttribute(String name, Object value, Tag tag) {
        attributes.add(new ClientAttribute(name, value, null, tag));
        return this;
    }

    @Override
    public ClientPresentationModelBuilder withAttribute(String name, Object value, String qualifier) {
        attributes.add(new ClientAttribute(name, value, qualifier));
        return this;
    }

    @Override
    public ClientPresentationModelBuilder withAttribute(String name, Object value, String qualifier, Tag tag) {
        attributes.add(new ClientAttribute(name, value, qualifier, tag));
        return this;
    }

    @Override
    public ClientPresentationModel create() {
        return dolphin.presentationModel(id, type, attributes.toArray(new ClientAttribute[attributes.size()]));
    }

}