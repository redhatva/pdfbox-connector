/*
 * Copyright 2023 Salesforce, Inc. All rights reserved.
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.avodagroup.connectors.pdfBox.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.apache.pdfbox.multipdf.PageExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class PdfBoxOperations {

  @MediaType(value = "application/octet-stream", strict = false)
  public InputStream splitPdf(@DisplayName("Content") InputStream content, @DisplayName("Start Page") int startPage, @DisplayName("End Page") int endPage){
    try (PDDocument origDoc = Loader.loadPDF(content.readAllBytes())) {
      PDDocument extractedDoc = extractPage(origDoc, startPage, endPage);

      ByteArrayOutputStream out = new ByteArrayOutputStream();
      extractedDoc.save(out);
      extractedDoc.close();

      return new ByteArrayInputStream(out.toByteArray());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @MediaType(value = ANY, strict = false)
  public int getPageCount(@DisplayName("Content") InputStream content){
    try (PDDocument origDoc = Loader.loadPDF(content.readAllBytes())) {
      return origDoc.getNumberOfPages();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private PDDocument extractPage(PDDocument document, int startPage, int endPage) throws IOException {
    PageExtractor extractor = new PageExtractor(document, startPage, endPage);

      return extractor.extract();
  }
}
