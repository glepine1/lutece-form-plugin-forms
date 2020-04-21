

<#include "all_entry_commons.ftl" />

<@breadforms title=entry.entryType.title />
<@box color='primary'>
	<@boxHeader title='#i18n{forms.createEntry.titleQuestion} : "${form.title}"' />
	<@boxBody>
		<fieldset>
		<legend class="sr-only">#i18n{forms.createEntry.titleComment} : '${form.title}'</legend>
		<@tform action='jsp/admin/plugins/forms/ManageQuestions.jsp'>
			<input name="id_type" value="${entry.entryType.idType}" type="hidden">
			<#if entry.fieldDepend?exists>
				<input name="id_field" value="${entry.fieldDepend.idField}" type="hidden">
			</#if>
			<input name="id_parent" value="${id_parent!'0'}" type="hidden">
			<input name="id_step" value="${step.id!'0'}" type="hidden">
			<@formGroup labelFor='type' labelKey='#i18n{forms.createEntry.labelType}'>
				<@input type='text' name='type' id='type' readonly=true disabled=true value='${entry.entryType.title}' />
			</@formGroup>
                        <@formGroup labelFor='entry_code' labelKey='#i18n{forms.createEntry.labelCode}' helpKey='#i18n{forms.createEntry.labelCodeComment}'>
				<@input type='text' name='entry_code' id='entry_code' value='' maxlength=100 />
			</@formGroup>
			<@formGroup labelFor='comment' labelKey='#i18n{forms.createEntry.labelComment}' mandatory=true>
				<@input type='textarea' name='comment' id='comment' rows=5 richtext=true></@input>
			</@formGroup>
			<@formGroup labelFor='css_class' labelKey='#i18n{forms.createEntry.labelCSSClass}' helpKey='#i18n{forms.createEntry.labelCSSClassComment}'>
				<@input type='text' name='css_class' id='css_class' value='' maxlength=255 />
			</@formGroup>
			<@formGroup labelFor='is_indexed' labelKey='#i18n{forms.createEntry.labelResponsesIndexed}' helpKey='#i18n{forms.createEntry.labelResponsesIndexedComment}'>
					<@checkBox name='is_indexed' id='is_indexed' value='1' checked=false />
			</@formGroup>
			${question_create_template!}
			<@formGroup>
				<@button type='submit' name='action_createQuestion' buttonIcon='save' title='#i18n{forms.modifyEntry.buttonSave}' showTitleXs=false size='' />
				<@aButton href='jsp/admin/plugins/forms/ManageQuestions.jsp?id_step=${step.id}' buttonIcon='close' title='#i18n{forms.createEntry.buttonCancel}' showTitleXs=false size='' color='btn-secondary' />
			</@formGroup>
		</@tform>
		</fieldset>
	</@boxBody>
</@box>

<#include "/admin/util/editor/editor.ftl" />
<@initEditor />

 