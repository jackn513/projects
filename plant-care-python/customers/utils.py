from django.contrib.auth.models import User
from .models import Customer
from django.db import transaction


@transaction.atomic
def create_customer_with_user(email, password, customer_name, role='user'):
    # Create a User
    user = User.objects.create_user(username=email, email=email, password=password)

    # Create a Customer profile linked to the User
    customer = Customer.objects.create(
        user=user,
        customer_name=customer_name,
        email=email,
        role=role
    )

    return customer


@transaction.atomic
def create_customer(email, customer_name, password, role='user'):
    customer = Customer.objects.create(
        customer_name=customer_name,
        email=email,
        password=password,
        role=role
    )
    return customer
