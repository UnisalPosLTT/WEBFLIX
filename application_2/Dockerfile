FROM tomcat:8
MAINTAINER Thiago Teberga<thiiteberga@gmail.com>

RUN  export DEBIAN_FRONTEND=noninteractive
ENV  DEBIAN_FRONTEND noninteractive
RUN  dpkg-divert --local --rename --add /sbin/initctl

COPY application/webflix.war /usr/local/tomcat/webapps
#ENV APPLICATION_LINK_WARhttps://github.com/thiagoteberga/dockerfile/blob/master/application_2/thiago.war

#RUN mkdir -p /tmp/resources

#RUN wget ${APPLICATION_LINK_WAR} -P /tmp/resources \
#    # && unzip -c /tmp/resources/app.war \
#    && mv /tmp/resources/*.war /usr/local/tomcat/webapps

EXPOSE 8080
