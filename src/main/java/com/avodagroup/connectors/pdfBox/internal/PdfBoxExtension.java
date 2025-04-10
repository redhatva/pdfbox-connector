/*
 * Copyright 2025 Avoda Group Inc. All rights reserved.
 * The software in this package is published under the terms of the MIT
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.avodagroup.connectors.pdfBox.internal;

import org.mule.runtime.extension.api.annotation.Extension;

import static org.mule.sdk.api.meta.JavaVersion.JAVA_17;

import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.sdk.api.annotation.JavaVersionSupport;


@Xml(prefix = "pdfbox")
@Extension(name = "PdfBox")
@Configurations(PdfBoxConfiguration.class)
@JavaVersionSupport({JAVA_17})
public class PdfBoxExtension {

}
