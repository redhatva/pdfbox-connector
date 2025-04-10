/*
 * Copyright 2023 Salesforce, Inc. All rights reserved.
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.avodagroup.connectors.pdfBox.internal;

import org.mule.runtime.extension.api.annotation.Extension;

import static org.mule.sdk.api.meta.JavaVersion.JAVA_17;

import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.sdk.api.annotation.JavaVersionSupport;


/**
 * This is the main class of an extension, is the entry point from which configurations, connection providers, operations
 * and sources are going to be declared.
 */
@Xml(prefix = "pdfbox")
@Extension(name = "PdfBox")
@Configurations(PdfBoxConfiguration.class)
@JavaVersionSupport({JAVA_17})
public class PdfBoxExtension {

}
