package com.santiago.proyectohibernate.projection;

public interface UserProjection {
    Long getId();

    String getFirstName();

    String getEmail();

    String getDni();

    Boolean getActive();
}
