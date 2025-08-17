package com.example.store;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class ProductApplication extends Application {
    // This class enables JAX-RS and makes your REST endpoints discoverable
}