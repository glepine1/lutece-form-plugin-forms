package fr.paris.lutece.plugins.forms.util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.paris.lutece.plugins.forms.business.Form;
import fr.paris.lutece.plugins.forms.business.FormDisplayHome;
import fr.paris.lutece.plugins.forms.business.GroupHome;
import fr.paris.lutece.plugins.forms.business.Question;
import fr.paris.lutece.plugins.forms.business.Step;
import fr.paris.lutece.plugins.forms.business.Transition;
import fr.paris.lutece.plugins.genericattributes.business.Entry;
import fr.paris.lutece.plugins.genericattributes.business.Field;
import fr.paris.lutece.plugins.genericattributes.business.FieldHome;

public final class JsonUtils
{
    public static final String MIME_TYPE = "application/json";
    
    private JsonUtils( )
    {
    }
    
    public static JSONObject createFormJsonObject( Form form )
    {
        JSONObject jsonObject = new JSONObject( );
        jsonObject.accumulate( "title", form.getTitle( ) );
        jsonObject.accumulate( "description", form.getDescription( ) );
        jsonObject.accumulate( "workgroup", form.getWorkgroup( ) );
        jsonObject.accumulate( "idWorkflow", form.getIdWorkflow( ) );
        jsonObject.accumulate( "authentificationNeeded", form.isAuthentificationNeeded( ) );
        jsonObject.accumulate( "breadcrumbName", form.getBreadcrumbName( ) );
        jsonObject.accumulate( "returnUrl", form.getReturnUrl( ) );
        jsonObject.accumulate( "displaySummary", form.isDisplaySummary( ) );
        jsonObject.accumulate( "maxNumberResponse", form.getMaxNumberResponse( ) );
        jsonObject.accumulate( "oneResponseByUser", form.isOneResponseByUser( ) );
        return jsonObject;
    }
    
    public static void addFormStepsArray( JSONObject formObject, List<Step> stepList )
    {
        JSONArray jsonArray = new JSONArray( );
        for ( Step step : stepList )
        {
            JSONObject stepObject = new JSONObject( );
            stepObject.accumulate( "title", step.getTitle( ) );
            stepObject.accumulate( "description", step.getDescription( ) );
            stepObject.accumulate( "isInitial", step.isInitial( ) );
            stepObject.accumulate( "isFinal", step.isFinal( ) );
            jsonArray.put( stepObject );
        }
        formObject.accumulate( "steps", jsonArray );
    }
    
    public static void addFormTransitionsArray( JSONObject formObject, List<Transition> transitionList )
    {
        JSONArray jsonArray = new JSONArray( );
        for ( Transition transition : transitionList )
        {
            JSONObject transitionObject = new JSONObject( );
            transitionObject.accumulate( "fromStep", transition.getFromStepTitle( ) );
            transitionObject.accumulate( "nextStep", transition.getNextStepTitle( ) );
            transitionObject.accumulate( "priority", transition.getPriority( ) );
            jsonArray.put( transitionObject );
        }
        formObject.accumulate( "transitions", jsonArray );
    }
    
    public static void addFormQuestionArray( JSONObject formObject, List<Question> questionList )
    {
        JSONArray jsonArray = new JSONArray( );
        for ( Question question : questionList )
        {
            JSONObject questionObject = new JSONObject( );
            questionObject.accumulate( "title", question.getTitle( ) );
            questionObject.accumulate( "code", question.getCode( ) );
            questionObject.accumulate( "description", question.getDescription( ) );
            questionObject.accumulate( "entry", createEntryJsonObject( question.getEntry( ) ) );
            jsonArray.put( questionObject );
        }
        formObject.accumulate( "questions", jsonArray );
    }
    
    private static JSONObject createFormDisplayArray( Step step )
    {
        
    }
    
    private static JSONObject createEntryJsonObject( Entry entry )
    {
        JSONObject entryObject = new JSONObject( );
        entryObject.accumulate( "id_type", entry.getEntryType( ).getIdType( ) );
        entryObject.accumulate( "title", entry.getTitle( ) );
        entryObject.accumulate( "code", entry.getCode( ) );
        entryObject.accumulate( "help_message", entry.getHelpMessage( ) );
        entryObject.accumulate( "comment", entry.getComment( ) );
        entryObject.accumulate( "mandatory", entry.isMandatory( ) );
        entryObject.accumulate( "fields_in_line", entry.isFieldInLine( ) );
        entryObject.accumulate( "pos", entry.getPosition( ) );
        entryObject.accumulate( "id_field_depend", entry.getFieldDepend( ) );
        entryObject.accumulate( "field_unique", entry.isUnique( ) );
        entryObject.accumulate( "css_class", entry.getCSSClass( ) );
        entryObject.accumulate( "pos_conditional", entry.getPosition( ) );
        entryObject.accumulate( "error_message", entry.getErrorMessage( ) );
        entryObject.accumulate( "is_only_display_back", entry.isOnlyDisplayInBack( ) );
        entryObject.accumulate( "is_editable_back", entry.isEditableBack( ) );
        entryObject.accumulate( "is_indexed", entry.isIndexed( ) );
        
        List<Field> listField = FieldHome.getFieldListByIdEntry( entry.getIdEntry( ) );
        JSONArray jsonArray = new JSONArray( );
        for ( Field field : listField )
        {
            JSONObject fieldObject = new JSONObject( );
            fieldObject.accumulate( "title", field.getTitle( ) );
            fieldObject.accumulate( "code", field.getCode( ) );
            fieldObject.accumulate( "value", field.getValue( ) );
            fieldObject.accumulate( "default_value", field.isDefaultValue( ) );
            fieldObject.accumulate( "pos", field.getPosition( ) );
            fieldObject.accumulate( "value_type_date", field.getValueTypeDate( ) );
            fieldObject.accumulate( "no_display_title", field.isNoDisplayTitle( ));
            fieldObject.accumulate( "comment", field.getComment( ) );
            jsonArray.put( fieldObject );
        }
        entryObject.accumulate( "fields", jsonArray );
        return entryObject;
    }
}
