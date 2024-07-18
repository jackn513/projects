from django.contrib.auth.hashers import make_password
from django.shortcuts import redirect, render

from customers.forms import CustomerForm
from customers.utils import create_customer


def register_customer(request):
    if request.method == 'POST':
        form = CustomerForm(request.POST, request.FILES)
        if form.is_valid():
            email = form.cleaned_data['email']
            customer_name = form.cleaned_data['customer_name']
            raw_password = 'generate_password_or_get_from_form'  # Example: Generate or get password
            password = make_password(raw_password)  # Hash password

            customer = create_customer(
                email=email,
                password=password,
                customer_name=customer_name,

            )

            return redirect('home')  # Redirect to profile page or any other view

    else:
        form = CustomerForm()

    return render(request, 'register.html', {'form': form})
