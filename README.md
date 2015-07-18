# paxweb-863
simple example of paxweb issue 863


Download a clean copy of karaf 3.0.3 (3.0.4 had issues on my windows machine, features service wouldn't start)

I'm running java 1.8.0_25 (however, the code should most likely compile against 1.7 if you change the pom target version)

`mvn install`

Fire up karaf and from the console:


`feature:repo-add mvn:org.apache.cxf.karaf/apache-cxf/3.1.1/xml/features`

`feature:repo-add mvn:org.apache.camel.karaf/apache-camel/2.15.2/xml/features`

`feature:repo-add mvn:com.edjusted/karaf-feature/0.1.0-SNAPSHOT/xml/features`


There are two feature options, one is the webservice implementation using just straight CXF:

`feature:install -v edjusted-karaf-feature-cxf`

The other is the webservice implementation using camel and cxf:

`feature:install -v edjusted-karaf-feature-camel`

NOTE you can't install both features at the same time because they bind to the exact same path for the webservice.

you should be able to pull up the WSDL at: http://localhost:8181/cxf/test?WSDL

You can punch that WSDL into a new SoapUI project (if you by chance have it installed)
 
Otherwise, you can exercise the webservice with curl (assuming you run it from this directory, or you may have to update the reference to the samplepayload.xml file):

`curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction: " -d @samplepayload.xml http://localhost:8181/cxf/test/`
