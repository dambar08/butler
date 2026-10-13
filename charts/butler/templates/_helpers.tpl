{{/*
Expand the chart name.
*/}}
{{- define "butler.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a release-qualified name.
*/}}
{{- define "butler.fullname" -}}
{{- if .Values.fullnameOverride -}}
{{- .Values.fullnameOverride | trunc 63 | trimSuffix "-" -}}
{{- else -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- if contains $name .Release.Name -}}
{{- .Release.Name | trunc 63 | trimSuffix "-" -}}
{{- else -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}
{{- end -}}
{{- end -}}

{{/*
Common chart labels.
*/}}
{{- define "butler.labels" -}}
helm.sh/chart: {{ printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/name: {{ include "butler.name" . }}
{{- end -}}

{{/*
Selector labels shared by a workload and its service.
*/}}
{{- define "butler.selectorLabels" -}}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/name: {{ include "butler.name" . }}
{{- end -}}

{{/*
Select the secret used to initialize the chart-managed PostgreSQL instance.
*/}}
{{- define "butler.postgresqlSecretName" -}}
{{- .Values.postgresql.auth.existingSecret | default (printf "%s-postgresql" (include "butler.fullname" .)) -}}
{{- end -}}

{{/*
Select credentials for the application database connection.
*/}}
{{- define "butler.databaseSecretName" -}}
{{- if .Values.app.database.url -}}
{{- required "app.database.secretName is required when app.database.url is set" .Values.app.database.secretName -}}
{{- else -}}
{{- if not .Values.postgresql.enabled -}}
{{- fail "postgresql.enabled must be true when app.database.url is empty" -}}
{{- end -}}
{{- include "butler.postgresqlSecretName" . -}}
{{- end -}}
{{- end -}}
