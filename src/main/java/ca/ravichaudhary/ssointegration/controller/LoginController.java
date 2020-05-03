package ca.ravichaudhary.ssointegration.controller;

import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LoginController {
    private final RelyingPartyRegistrationRepository relyingParties;

    public LoginController(RelyingPartyRegistrationRepository relyingParties) {
        this.relyingParties = relyingParties;
    }

//    @Bean
//    public RelyingPartyRegistrationRepository relyingPartyRegistrationRepository() {
//        //SAML configuration
//        //Mapping this application to one or more Identity Providers
//        return new InMemoryRelyingPartyRegistrationRepository(...);
//    }


    @GetMapping("/pub/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String registrationId = request.getParameter("id");
        RelyingPartyRegistration relyingPartyRegistration = this.relyingParties
                .findByRegistrationId(registrationId);

        if(relyingPartyRegistration != null) {
            response.sendRedirect("/saml2/authenticate/" + registrationId);
        } else {
            response.setStatus(401);
        }
    }
}
