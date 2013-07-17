/* LanguageTool, a natural language style checker
 * Copyright (C) 2013 Daniel Naber (http://www.danielnaber.de)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.dev.wikipedia;

import java.util.List;

/**
 * The result of a Wikipedia check that takes markup into account so
 * that the suggestions can be applied to that original markup.
 */
public class MarkupAwareWikipediaResult {

  private final String originalWikiMarkup;
  private final List<RuleApplication> ruleApplications;
  private final int internalErrors;

  public MarkupAwareWikipediaResult(String originalWikiMarkup, List<RuleApplication> ruleApplications, int internalErrors) {
    this.originalWikiMarkup = originalWikiMarkup;
    this.ruleApplications = ruleApplications;
    this.internalErrors = internalErrors;
  }

  public List<RuleApplication> getRuleApplications() {
    return ruleApplications;
  }

  /**
   * Mapping the Wikipedia syntax is complicated and it sometimes fails. We
   * try to skip over those problems and increase this counter. Each increment
   * here means that one rule match is missing from the rule applications.
   */
  public int getInternalErrorCount() {
    return internalErrors;
  }

  public String getOriginalWikiMarkup() {
    return originalWikiMarkup;
  }
}
