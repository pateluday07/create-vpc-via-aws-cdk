package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.SubnetConfiguration;
import software.amazon.awscdk.services.ec2.SubnetType;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.VpcProps;
import software.constructs.Construct;

import java.util.Collections;

public class CdkJavaDemoStack extends Stack {
    public CdkJavaDemoStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public CdkJavaDemoStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        SubnetConfiguration subnetConfiguration = SubnetConfiguration
                .builder()
                .cidrMask(24)
                .name("public-subnet")
                .subnetType(SubnetType.PUBLIC)
                .build();

        VpcProps vpcProps = VpcProps
                .builder()
                .maxAzs(3)
                .subnetConfiguration(Collections.singletonList(subnetConfiguration))
                .build();

        new Vpc(this, "JavaVpc", vpcProps);
    }
}
