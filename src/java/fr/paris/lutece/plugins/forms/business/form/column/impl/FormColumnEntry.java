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
package fr.paris.lutece.plugins.forms.business.form.column.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the FormColumn for the Entry column
 */
public class FormColumnEntry extends AbstractFormColumn
{
    // Variables
    private List<String> _listEntryTitle = new ArrayList<>( );

    /**
     * Constructor
     * 
     * @param nFormColumnPosition
     *            The position of the FormColumn
     * @param strFormColumnTitle
     *            The title of the FormColumn
     * @param listEntryTitle
     *            The list of Entry title on which the FormColumn must be filter on
     */
    public FormColumnEntry( int nFormColumnPosition, String strFormColumnTitle, List<String> listEntryTitle )
    {
        super( );
        setFormColumnPosition( nFormColumnPosition );
        setFormColumnTitle( strFormColumnTitle );
        _listEntryTitle = listEntryTitle;
    }

    /**
     * Constructor
     * 
     * @param nFormColumnPosition
     * @param strFormColumnTitle
     */
    public FormColumnEntry( int nFormColumnPosition, String strFormColumnTitle )
    {
        super( );
        setFormColumnPosition( nFormColumnPosition );
        setFormColumnTitle( strFormColumnTitle );
    }

    /**
     * Return the list of Entry to filter on for the Form Column
     * 
     * @return the list of Entry to filter on for the Form Column
     */
    public List<String> getListEntryTitle( )
    {
        return _listEntryTitle;
    }

    /**
     * Set the list of Entry to filter on for the Form Column
     * 
     * @param listEntryTitle
     *            The list of Entry to filter on for the Form Column
     */
    public void setListEntryTitle( List<String> listEntryTitle )
    {
        _listEntryTitle = listEntryTitle;
    }

    public void addEntryTitle( String strEntryTitle )
    {
        _listEntryTitle.add( strEntryTitle );
    }
}
