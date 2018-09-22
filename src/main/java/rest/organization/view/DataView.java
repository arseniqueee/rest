package rest.organization.view;

import rest.organization.model.Organization;

import java.util.List;

public class DataView {

    public List<Organization> data;

    public DataView(List<Organization> data) {
        this.data = data;
    }
}
