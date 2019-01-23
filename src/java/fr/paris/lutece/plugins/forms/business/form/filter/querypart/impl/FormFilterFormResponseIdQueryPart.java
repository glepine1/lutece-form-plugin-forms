/*
 * Copyright (c) 2002-2018, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.forms.business.form.filter.querypart.impl;

import fr.paris.lutece.plugins.forms.business.form.FormParameters;
import fr.paris.lutece.plugins.forms.business.form.filter.FormFilterQueryBuilder;

/**
 * Implementation of the IFormFilterQueryPart for a FormFilterWorkflowState filter
 */
public class FormFilterFormResponseIdQueryPart extends AbstractFormFilterQueryPart
{
    // Constants
    private static final String LIST_RESPONSE_ID_QUERY_PATTERN_BEGIN = "response.id_response IN ( ";
    private static final String LIST_RESPONSE_ID_QUERY_PATTERN_END = ")";
    private static final String CONSTANT_COMMA = ",";
    private static final String PARAMETER_QUESTION_MARK = "?";

    /**
     * {@inheritDoc}
     */
    @Override
    public void buildFormFilterQuery( FormParameters formParameters )
    {
        StringBuilder strBuilderFilterQuery = new StringBuilder( );
        strBuilderFilterQuery.append( LIST_RESPONSE_ID_QUERY_PATTERN_BEGIN );
        for ( int i = 0; i < formParameters.getFormParametersMap( ).size( ); i++ )
        {
            strBuilderFilterQuery.append( PARAMETER_QUESTION_MARK );
            if ( i != formParameters.getFormParametersMap( ).size( ) - 1 )
            {
                strBuilderFilterQuery.append( CONSTANT_COMMA );
            }
        }
        strBuilderFilterQuery.append( LIST_RESPONSE_ID_QUERY_PATTERN_END );
        setFormFilterQuery( FormFilterQueryBuilder.buildFormFilterQuery( strBuilderFilterQuery.toString( ), formParameters, false ) );
    }
}