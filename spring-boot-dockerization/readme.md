######Following plugin element provides creating a docker image:
            <plugin>
                <groupId>io.fabric8</groupId>
                <artifactId>docker-maven-plugin</artifactId>
                <version>0.26.0</version>
                <extensions>true</extensions>
                <configuration>
                    <verbose>true</verbose>
                    <images>
                        <image>
                            <name>${project.artifactId}</name>
                            <build>
                                <from>java:8-jdk-alpine</from>
                                <entryPoint>
                                    <exec>
                                        <args>java</args>
                                        <args>-jar</args>
                                        <args>/maven/${project.artifactId}-${project.version}.jar</args>
                                    </exec>
                                </entryPoint>
                                <assembly>
                                    <descriptorRef>artifact</descriptorRef>
                                </assembly>
                            </build>
                        </image>
                    </images>
                </configuration>
                <executions>
                    <execution>
                        <id>build</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>build</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            
            
######The relevant docker image can be run with the following command:
$ docker run spring-boot-dockerization