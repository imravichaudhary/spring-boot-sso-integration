# spring-boot-sso-integration
Sample Spring boot project to test multiple IDP support for SSO integration

This project was created for myself to test out multiple IDP(Identity Provider) using Spring boot and Spring Security for SSO(Single sign-on) integration.

The sample acts as the SP(Service Provider).

The project has been configured to be used as both SP initiated and IDP initiated.

IDP configuration information:
- Azure:
  - Identifier (Entity ID): https://localhost:8443/saml2/service-provider-metadata/idpone
  - Reply URL (Assertion Consumer Service URL): https://localhost:8443/login/saml2/sso/idpone
- Okta:
  - Single sign on URL: https://localhost:8443/login/saml2/sso/idptwo
  - Audience URI (SP Entity ID): https://localhost:8443/saml2/service-provider-metadata/idptwo
  
Note: Here **idpone** and **idptwo** are registrationId configured in the **application.yml**. You can provide your custom registrationId but be sure to configure relevant IDP service.

