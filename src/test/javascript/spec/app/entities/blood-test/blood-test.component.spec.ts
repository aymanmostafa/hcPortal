/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { BloodTestComponent } from '../../../../../../main/webapp/app/entities/blood-test/blood-test.component';
import { BloodTestService } from '../../../../../../main/webapp/app/entities/blood-test/blood-test.service';
import { BloodTest } from '../../../../../../main/webapp/app/entities/blood-test/blood-test.model';

describe('Component Tests', () => {

    describe('BloodTest Management Component', () => {
        let comp: BloodTestComponent;
        let fixture: ComponentFixture<BloodTestComponent>;
        let service: BloodTestService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [BloodTestComponent],
                providers: [
                    BloodTestService
                ]
            })
            .overrideTemplate(BloodTestComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(BloodTestComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BloodTestService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new BloodTest('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.bloodTests[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
