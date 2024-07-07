# forms.py

from django import forms


class CustomerForm(forms.Form):
    email = forms.EmailField()
    customer_name = forms.CharField(max_length=100)
    password = forms.CharField(widget=forms.PasswordInput)
