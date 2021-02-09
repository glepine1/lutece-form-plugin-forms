package fr.paris.lutece.plugins.forms.util;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.plugins.forms.business.Form;
import fr.paris.lutece.portal.service.security.SecurityService;
import fr.paris.lutece.portal.service.security.UserNotSignedException;

/**
 *  Utility class for form security
 */
public final class FormSecurityUtil
{
    private FormSecurityUtil( )
    {
    }
    
    /**
     * check if authentification
     * 
     * @param form
     *            Form
     * @param request
     *            HttpServletRequest
     * @throws UserNotSignedException
     *             exception if the form requires an authentification and the user is not logged
     */
    public static void checkMyLuteceAuthentification( Form form, HttpServletRequest request ) throws UserNotSignedException
    {
        // Try to register the user in case of external authentication
        if ( !SecurityService.isAuthenticationEnable( ) )
        {
            return;
        }
        if ( SecurityService.getInstance( ).isExternalAuthentication( ) )
        {
            // The authentication is external
            // Should register the user if it's not already done
            if ( SecurityService.getInstance( ).getRegisteredUser( request ) == null && SecurityService.getInstance( ).getRemoteUser( request ) == null
                    && form.isAuthentificationNeeded( ) )
            {
                // Authentication is required to access to the portal
                throw new UserNotSignedException( );
            }
        }
        else
        {
            // If portal authentication is enabled and user is null and the requested URL
            // is not the login URL, user cannot access to Portal
            if ( ( form.isAuthentificationNeeded( ) ) && ( SecurityService.getInstance( ).getRegisteredUser( request ) == null )
                    && !SecurityService.getInstance( ).isLoginUrl( request ) )
            {
                // Authentication is required to access to the portal
                throw new UserNotSignedException( );
            }
        }
    }
}
