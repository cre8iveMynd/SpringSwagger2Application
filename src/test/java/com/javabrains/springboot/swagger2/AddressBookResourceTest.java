package com.javabrains.springboot.swagger2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AddressBookResource.class})
@ExtendWith(SpringExtension.class)
class AddressBookResourceTest {
    @Autowired
    private AddressBookResource addressBookResource;

    /**
     * Method under test: {@link AddressBookResource#addContact(Contact)}
     */
    @Test
    void testAddContact() throws Exception {
        Contact contact = new Contact();
        contact.setId("42");
        contact.setName("Name");
        contact.setPhone("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(contact);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.addressBookResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"id\":\"42\",\"name\":\"Name\",\"phone\":\"4105551212\"}"));
    }

    /**
     * Method under test: {@link AddressBookResource#addContact(Contact)}
     */
    @Test
    void testAddContact2() throws Exception {
        Contact contact = new Contact();
        contact.setId("42");
        contact.setName("Name");
        contact.setPhone("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(contact);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/", "Uri Vars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.addressBookResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"id\":\"42\",\"name\":\"Name\",\"phone\":\"4105551212\"}"));
    }

    /**
     * Method under test: {@link AddressBookResource#getAllContacts()}
     */
    @Test
    void testGetAllContacts() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/");
        MockMvcBuilders.standaloneSetup(this.addressBookResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":\"\",\"name\":\"?\",\"phone\":\"4105551212\"},{\"id\":\"??\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42"
                                        + "?\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42Id\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"4242"
                                        + "\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?Id\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"Id\","
                                        + "\"name\":\"?\",\"phone\":\"4105551212\"},{\"id\":\"Id42\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?42\",\"name"
                                        + "\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?\",\"name\":\"Name"
                                        + "\",\"phone\":\"\"}]"));
    }

    /**
     * Method under test: {@link AddressBookResource#getAllContacts()}
     */
    @Test
    void testGetAllContacts2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.addressBookResource)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":\"\",\"name\":\"?\",\"phone\":\"4105551212\"},{\"id\":\"??\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42"
                                        + "?\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42Id\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"4242"
                                        + "\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?Id\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"Id\","
                                        + "\"name\":\"?\",\"phone\":\"4105551212\"},{\"id\":\"Id42\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?42\",\"name"
                                        + "\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?\",\"name\":\"Name"
                                        + "\",\"phone\":\"\"}]"));
    }

    /**
     * Method under test: {@link AddressBookResource#getContact(String)}
     */
    @Test
    void testGetContact() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/{id}", "42");
        MockMvcBuilders.standaloneSetup(this.addressBookResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"id\":\"42\",\"name\":\"Name\",\"phone\":\"4105551212\"}"));
    }

    /**
     * Method under test: {@link AddressBookResource#getContact(String)}
     */
    @Test
    void testGetContact2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/{id}", "42");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.addressBookResource)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"id\":\"42\",\"name\":\"Name\",\"phone\":\"4105551212\"}"));
    }

    /**
     * Method under test: {@link AddressBookResource#getContact(String)}
     */
    @Test
    void testGetContact3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/{id}", "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.addressBookResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":\"\",\"name\":\"?\",\"phone\":\"4105551212\"},{\"id\":\"??\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42"
                                        + "?\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42Id\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"4242"
                                        + "\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?Id\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"Id\","
                                        + "\"name\":\"?\",\"phone\":\"4105551212\"},{\"id\":\"Id42\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?42\",\"name"
                                        + "\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?\",\"name\":\"Name"
                                        + "\",\"phone\":\"\"}]"));
    }

    /**
     * Method under test: {@link AddressBookResource#getContact(String)}
     */
    @Test
    void testGetContact4() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/{id}", "", "Uri Vars");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.addressBookResource)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":\"\",\"name\":\"?\",\"phone\":\"4105551212\"},{\"id\":\"??\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42"
                                        + "?\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42Id\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"4242"
                                        + "\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?Id\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"Id\","
                                        + "\"name\":\"?\",\"phone\":\"4105551212\"},{\"id\":\"Id42\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?42\",\"name"
                                        + "\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"42\",\"name\":\"Name\",\"phone\":\"4105551212\"},{\"id\":\"?\",\"name\":\"Name"
                                        + "\",\"phone\":\"\"}]"));
    }
}

