package by.ladyka.purchase;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PurchaseApplication.class)
@WebAppConfiguration
public class ProductControllerTest {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;


    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }
    int i = 0;

    @Test
    public void createRecord() throws Exception {
        System.err.println("TEST PC create" + i );
        i++;
    }

    @Test
    public void getRecord() throws Exception {
        System.err.println("TEST PC get" + i );
        i++;
    }

    @Test
    public void getRecords() throws Exception {
        mockMvc.perform(get("/password"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType));
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(this.bookmarkList.get(0).getId().intValue())))
//                .andExpect(jsonPath("$[0].uri", is("http://bookmark.com/1/" + userName)))
//                .andExpect(jsonPath("$[0].description", is("A description")))
//                .andExpect(jsonPath("$[1].id", is(this.bookmarkList.get(1).getId().intValue())))
//                .andExpect(jsonPath("$[1].uri", is("http://bookmark.com/2/" + userName)))
//                .andExpect(jsonPath("$[1].description", is("A description")));
    }

    @Test
    public void editRecord() throws Exception {
        System.err.println("TEST PC edit" + i );
        i++;
    }

    @Test
    public void deleteRecord() throws Exception {
        System.err.println("TEST PC delete" + i );
        i++;
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
